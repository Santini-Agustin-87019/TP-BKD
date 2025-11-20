package com.tpi.ms_operaciones.service.implementacion;

import com.tpi.ms_operaciones.dto.CostoResponse;
import com.tpi.ms_operaciones.dto.RutaRequest;
import com.tpi.ms_operaciones.dto.RutaResponse;
import com.tpi.ms_operaciones.dto.SolicitudRequest;
import com.tpi.ms_operaciones.dto.SolicitudResponse;
import com.tpi.ms_operaciones.dto.TramoDto;
import com.tpi.ms_operaciones.entity.Ruta;
import com.tpi.ms_operaciones.entity.Solicitud;
import com.tpi.ms_operaciones.entity.Tramo;
import com.tpi.ms_operaciones.enums.EstadoSolicitud;
import com.tpi.ms_operaciones.enums.EstadoTramo;
import com.tpi.ms_operaciones.enums.TipoTramo;
import com.tpi.ms_operaciones.repository.RutaRepository;
import com.tpi.ms_operaciones.repository.SolicitudRepository;
import com.tpi.ms_operaciones.repository.TramoRepository;
import com.tpi.ms_operaciones.service.OperacionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OperacionesServiceImpl implements OperacionesService {

    private final SolicitudRepository solicitudRepository;
    private final RutaRepository rutaRepository;
    private final TramoRepository tramoRepository;

    @Value("${operaciones.tarifa-base-km}")
    private BigDecimal tarifaBaseKm;

    @Value("${operaciones.velocidad-promedio-kmh}")
    private Double velocidadPromedioKmh;

    @Override
    public SolicitudResponse crearSolicitud(SolicitudRequest request) {
        // Creamos la entidad Solicitud
        Solicitud solicitud = new Solicitud();
        solicitud.setClienteId(request.getClienteId());
        solicitud.setContenedorId(request.getContenedorId());
        solicitud.setEstado(EstadoSolicitud.SOLICITADA);

        solicitud = solicitudRepository.save(solicitud);

        // Armamos el DTO de respuesta usando builder
        return SolicitudResponse.builder()
                .nroSolicitud(solicitud.getNroSolicitud())
                .clienteId(solicitud.getClienteId())
                .contenedorId(solicitud.getContenedorId())
                .costoEstimado(solicitud.getCostoEstimado())
                .tiempoEstimado(solicitud.getTiempoEstimado())
                .costoFinal(solicitud.getCostoFinal())
                .tiempoReal(solicitud.getTiempoReal())
                .build();
    }

    @Override
    public RutaResponse generarRutaTentativa(RutaRequest request, Long solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        // Por ahora, distancia fija. Más adelante se reemplaza por Google Maps/OSRM.
        double distanciaKm = 100.0;

        BigDecimal costoTramo = tarifaBaseKm.multiply(BigDecimal.valueOf(distanciaKm));
        int tiempoMinutos = (int) ((distanciaKm / velocidadPromedioKmh) * 60);

        // Creamos la Ruta
        Ruta ruta = new Ruta();
        ruta.setSolicitud(solicitud);
        ruta.setCantidadTramos(1);
        ruta.setCantidadDepositos(0);

        // Creamos el Tramo
        Tramo tramo = new Tramo();
        tramo.setRuta(ruta);
        tramo.setOrigen(request.getOrigen());
        tramo.setDestino(request.getDestino());
        tramo.setDistanciaKm(distanciaKm);
        tramo.setCostoAproximado(costoTramo);
        tramo.setEstado(EstadoTramo.ESTIMADO);
        tramo.setTipo(TipoTramo.ORIGEN_DESTINO);

        List<Tramo> tramos = new ArrayList<>();
        tramos.add(tramo);
        ruta.setTramos(tramos);

        // Guardamos la ruta (y cascada tramos)
        ruta = rutaRepository.save(ruta);

        // Actualizamos la solicitud
        solicitud.setHojaDeRuta(ruta);
        solicitud.setCostoEstimado(costoTramo);
        solicitud.setTiempoEstimado(tiempoMinutos);
        solicitud.setEstado(EstadoSolicitud.PROGRAMADA);
        solicitudRepository.save(solicitud);

        // DTO de tramo para respuesta (sin tipo porque tu TramoDto no lo tiene)
        TramoDto tramoDto = TramoDto.builder()
                .id(tramo.getIdTramo())
                .origen(tramo.getOrigen())
                .destino(tramo.getDestino())
                .distanciaKm(tramo.getDistanciaKm())
                .costoAproximado(tramo.getCostoAproximado())
                .build();

        // DTO de ruta
        return RutaResponse.builder()
                .idRuta(ruta.getIdRuta())
                .tramos(List.of(tramoDto))
                .costoTotalEstimado(costoTramo)
                .tiempoTotalEstimado(tiempoMinutos)
                .build();
    }

    @Override
    public RutaResponse consultarRutaTentativaPorOrigenDestino(String origen, String destino) {
        // Solo para que compile; no es necesario para el TP.
        throw new UnsupportedOperationException("consulta de ruta tentativa por origen/destino no implementada");
    }

    @Override
    public void asignarRutaDefinitiva(Long solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        solicitud.setEstado(EstadoSolicitud.PROGRAMADA);
        solicitudRepository.save(solicitud);
    }

    @Override
    public void asignarCamionATramo(Long tramoId, Long camionId) {
        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new RuntimeException("Tramo no encontrado"));
        tramo.setCamionId(camionId);
        tramo.setEstado(EstadoTramo.ASIGNADO);
        tramoRepository.save(tramo);
    }

    @Override
    public void marcarInicioTramo(Long tramoId) {
        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new RuntimeException("Tramo no encontrado"));
        tramo.setFechaHoraInicio(LocalDateTime.now());
        tramo.setEstado(EstadoTramo.INICIADO);
        tramoRepository.save(tramo);
    }

    @Override
    public void marcarFinTramo(Long tramoId) {
        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new RuntimeException("Tramo no encontrado"));
        tramo.setFechaHoraFin(LocalDateTime.now());
        tramo.setEstado(EstadoTramo.FINALIZADO);
        tramoRepository.save(tramo);
    }

    @Override
    public CostoResponse obtenerCostoTotal(Long solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        return CostoResponse.builder()
                .solicitudId(solicitudId)
                .costoEstimado(solicitud.getCostoEstimado())
                .costoReal(solicitud.getCostoFinal())
                .build();
    }
}
