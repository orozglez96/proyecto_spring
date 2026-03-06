package init.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Venta;

public interface VentasRepository extends JpaRepository<Venta, Integer>{
	
	List<Venta> findByFechaBetween(LocalDateTime f1, LocalDateTime f2);
	
	//Devuelva la lista de ventas de un determinado cliente:
	List<Venta> findByClienteIdCliente(int idCliente);
}
