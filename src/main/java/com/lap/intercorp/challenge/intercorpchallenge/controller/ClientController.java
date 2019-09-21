package com.lap.intercorp.challenge.intercorpchallenge.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lap.intercorp.challenge.intercorpchallenge.model.Client;
import com.lap.intercorp.challenge.intercorpchallenge.model.ClientRepository;

@RestController
public class ClientController {
	private Double media=0.0;
	private Double desv=0.0;

@Autowired
private ClientRepository repo;
	
@PostMapping("creacliente")
Client creaCliente(@RequestBody Client cli){
	return repo.save(cli);
}

@GetMapping("kpideclientes")
Map <String, Double> kpiClientes(){
	ArrayList<Client> l = (ArrayList<Client>) repo.findAll();
	this.media=0.0;
	this.desv=0.0;
	media = (double) (l.stream().map( cli->( ((Client) cli).getEdad() ) ).reduce(0, (a, b) -> (a + b))/l.size()) ;
	
	Consumer<Client> consumer = c -> {
		this.desv = Math.pow((c.getEdad() - this.media), 2);
	};
	
	l.forEach(consumer);
	
	this.desv = Math.sqrt(this.desv / (l.size() -1) );
	
    HashMap<String, Double> m = new HashMap<>();
	m.put("media", media);
	m.put("desviacion", desv);
	return m;
}

@GetMapping("listclientes")
List<Client> listClientes() {
	
	return repo.findAll();
}

}
