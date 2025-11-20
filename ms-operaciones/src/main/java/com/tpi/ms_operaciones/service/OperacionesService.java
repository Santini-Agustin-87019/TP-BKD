package com.tpi.ms_operaciones.service;

import com.tpi.ms_operaciones.dto.CostoResponse;
import com.tpi.ms_operaciones.dto.RutaRequest;
import com.tpi.ms_operaciones.dto.RutaResponse;
import com.tpi.ms_operaciones.dto.SolicitudRequest;
import com.tpi.ms_operaciones.dto.SolicitudResponse;

public interface OperacionesService {

    SolicitudResponse crearSolicitud(SolicitudRequest request);

    RutaResponse generarRutaTentativa(RutaRequest request, Long solicitudId);

    RutaResponse consultarRutaTentativaPorOrigenDestino(String origen, String destino);

    void asignarRutaDefinitiva(Long solicitudId);

    void asignarCamionATramo(Long tramoId, Long camionId);

    void marcarInicioTramo(Long tramoId);

    void marcarFinTramo(Long tramoId);

    CostoResponse obtenerCostoTotal(Long solicitudId);
}
