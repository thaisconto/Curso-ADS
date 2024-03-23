/*Crie um array de números e filtre apenas os números divisíveis por 3.
  Em seguida, mapeie esses números para o quadrado de seus valores. */

  let numeros = [1,2,3,4,5,6,7,8,9,10];
  console.log(`Números: ${numeros}`);

 
  let numerosDivisivelPorTres = numeros.filter(numeros => numeros % 3 == 0);
  console.log(`Números divisíveis por três: ${numerosDivisivelPorTres}`);

   let numerosQuadrado = numerosDivisivelPorTres.map(numerosDivisivelPorTres => numerosDivisivelPorTres * numerosDivisivelPorTres);
  console.log(`Números ao quadrado: ${numerosQuadrado}`);
