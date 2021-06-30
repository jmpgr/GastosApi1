package es.gastosApi.rest;

import es.gastosApi.repositorios.CuentaDAO;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequestMapping(path = "/cuentas/search")
public class CuentaController {

    CuentaDAO cuentaDAO;

    public CuentaController(CuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    @GetMapping("/total")
    @ResponseBody
    public double getTotalEnCuenta(@RequestParam Long idCuenta, PersistentEntityResourceAssembler assembler) {
        double total = cuentaDAO.totalEnCuenta(idCuenta);
        return total;
    }
}
