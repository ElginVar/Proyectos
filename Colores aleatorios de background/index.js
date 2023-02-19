console.log("hola mundo");

// tipos de datos en JS

// String es una cadena de caracteres como por ejemplo "hola" "que tal"
// boolean, los cuales tienen solo dos valores como por ejemplo verdadero o falso
// null: es un valor nulo, o vacio pero esta definida 
// number: cualquier tipo de numero
// Undefined: es un valor vacio que esta definido pero no tiene un valor asignado
// object: estructuras que permiten agrupar otros tipos de datos

// definicion de variables
// var: hace una definicion de variable al tope del archivo (no es muy usada)
// let: tambien sirve para definir variables

let PrimeraVariable = "hola";
console.log(PrimeraVariable);

PrimeraVariable = "la variable cambio"; // cuando no se usa la palabra 
//reservada de let, nos indica que el valor anterior ya no nos interesa y vamos a cambiarlo
console.log(PrimeraVariable);

let miBoolean = true;
let miOtroBoolean = false;

let miNumero = 0;
let miNumero2 = -12;

console.log(miNumero, miNumero2, miBoolean, PrimeraVariable);

let undef;
console.log(undef);