package es.gastosApi.repositorios;

import comun.Movimiento;
import es.gastosApi.entidades.CuentaConId;
import es.gastosApi.entidades.MovimientoConId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovimientoDAOImpl implements MovimientoDAOCustom{

    @Autowired
    MovimientoDAO movimientoDAO;

    @Autowired
    CuentaDAO cuentaDAO;

    @Override
    public List<MovimientoConId> getMovimientosPorCategorias(String categoria, String iban) {
        final CuentaConId cuenta = cuentaDAO.findByIban(iban);
        List<MovimientoConId> movimientos = new ArrayList<>();
        for (Movimiento movimiento : cuenta.getMovimientos()) {
            MovimientoConId movimientoConId = (MovimientoConId) movimiento;
            if(movimientoConId.getCategoria().getNombreCategoria().equals(categoria)){
                movimientos.add(movimientoConId);
            }
        }
        return movimientos;
    }
}
