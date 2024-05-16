async function fetchCargos() {
    const response = await fetch('https://exercicio.free.beeceptor.com/cargo');
    // Também é possível utilizar endpoint: https://exerciciothais.free.beeceptor.com/
    const cargos = await response.json();
  
    const cargoSelect = document.getElementById('cargo');
  
    cargos.forEach(cargo => {
      const option = document.createElement('option');
      option.value = cargo.cargo;
      option.text = cargo.cargo;
      cargoSelect.appendChild(option);
    });
  
    cargoSelect.addEventListener('change', function() {
      const selectedCargo = this.value;
      const selectedCargoData = cargos.find(cargo => cargo.cargo === selectedCargo);
  
      if (selectedCargoData) {
        document.getElementById('cargoSalario').value = selectedCargoData.salario;
        document.getElementById('setorSigla').value = selectedCargoData.setorSigla;
        document.getElementById('setorNome').value = selectedCargoData.setorNome;
        document.getElementById('convenio').value = selectedCargoData.convenio; 
       document.getElementById('convenioTitularValor').value = selectedCargoData.valorTitular;
        document.getElementById('convenioDependenteValor').value = selectedCargoData.valorDependente; 
      } else {
        console.error('Cargo data not found:', selectedCargo);
        
      }
    });
  }
  
  fetchCargos();

  /*
  [
  {
    "cargo": "Cargo 1",
    "salario": 1000.00,
    "setorSigla": "S1",
    "setorNome": "Setor 1",
    "convenio": "Plano 1",
    "valorTitular": 100.00,
    "valorDependente": 50.00
  },
  {
    "cargo": "Cargo 2",
    "salario": 2000.00,
    "setorSigla": "S2",
    "setorNome": "Setor 2",
    "convenio": "Plano 2",
    "valorTitular": 200.00,
    "valorDependente": 100.00
  },
  {
    "cargo": "Cargo 3",
    "salario": 3000.00,
    "setorSigla": "S3",
    "setorNome": "Setor 3",
    "convenio": "Plano 3",
    "valorTitular": 300.00,
    "valorDependente": 150.00
  },
  {
    "cargo": "Cargo 4",
    "salario": 4000.00,
    "setorSigla": "S4",
    "setorNome": "Setor 4",
    "convenio": "Plano 3",
    "valorTitular": 300.00,
    "valorDependente": 150.00
  },
  {
    "cargo": "Cargo 5",
    "salario": 500.00,
    "setorSigla": "S1",
    "setorNome": "Setor 1",
    "convenio": "Plano 2",
    "valorTitular": 200.00,
    "valorDependente": 100.00
  },
  {
    "cargo": "Cargo 6",
    "salario": 6000.00,
    "setorSigla": "S2",
    "setorNome": "Setor 2",
    "convenio": "Plano 1",
    "valorTitular": 100.00,
    "valorDependente": 50.00
  },
  {
    "cargo": "Cargo 7",
    "salario": 7000.00,
    "setorSigla": "S3",
    "setorNome": "Setor 3",
    "convenio": "Plano 3",
    "valorTitular": 300.00,
    "valorDependente": 150.00
  },
  {
    "cargo": "Cargo 8",
    "salario": 8000.00,
    "setorSigla": "S8",
    "setorNome": "Setor 8",
    "convenio": "Plano 2",
    "valorTitular": 200.00,
    "valorDependente": 100.00
  }
]