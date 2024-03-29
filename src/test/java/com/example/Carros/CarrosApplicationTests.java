package com.example.Carros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.Carros.CarrosApplication;
import com.Carros.Carro.Carro;
import com.Carros.Carro.CarrosService;
import com.Carros.Carro.CarroDTO;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CarrosApplication.class)
public class CarrosApplicationTests {
	
	@Autowired
	private CarrosService service;

	@Test
	public void test1() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Luxo");
		
		CarroDTO c = service.insert(carro);
		
		assertNotNull(c);
		
		Long id = c.getId();
		assertNotNull(id);
		
		//Buscar Objeto
		c = service.getCarroById(id);
		assertNotNull(c);
		
		assertEquals("Ferrari", c.getNome());
		assertEquals("Luxo", c.getTipo());
		
		//Deletar objeto
		service.delete(id);
		
		//Verificar se deletou
		try {
			assertNull(service.getCarroById(id));
			fail("O carro não foi excluido");
		}catch (Exception e) {
			//ok
		}
	}
	
	@Test
	public void testeLista() {
		List<CarroDTO> carros =  service.getCarrosDB();
		//Nem sempre vai funcionar -> pois muda toda hora
		assertEquals(30, carros.size());
		
	}
	
	@Test
	public void get() {
		CarroDTO carro = service.getCarroById(11L);
		assertNotNull(carro);
			
		assertEquals("Ferrari FF", carro.getNome());
		
	}
	
	@Test
	public void getTipo() {
		
		
		assertEquals(10,service.getCarroByTipo("Classicos").size());
		assertEquals(10,service.getCarroByTipo("Esportivos").size());
		assertEquals(10,service.getCarroByTipo("Luxo").size());
		
		
	}


}
