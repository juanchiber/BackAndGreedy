SITUACION A RESOLVER:

Las autoridades de una ciudad deciden construir una red de subterráneos para resolver los constantes
problemas de tráfico. La ciudad ya cuenta con N estaciones construidas, pero todavía no tienen ningún
túnel que conecte ningún par de estaciones entre sí.
La red de subterráneos que se construya debe incluir a todas las estaciones (es decir, que de cualquier
estación H pueda llegar a cualquier otra estación J, ya sea de manera directa o atravesando otras
estaciones). Sin embargo, debido al acotado presupuesto, las autoridades desean construir la menor
cantidad de metros de túnel posibles . Para esto han calculado cuantos metros de túnel serían
necesarios para conectar de manera directa cada par de estaciones existentes.
Objetivo
El objetivo será resolver el problema planteado mediante dos técnicasalgorítmicas distintas: 

Backtracking y Greedy.

Luego se deberán comparar los resultados teniendo en cuenta distintas métricas que permitan visualizar,
mínimamente, la calidad de la solución y el costo de obtener dicha solución, con ambas técnicas.
Implementación
La aplicación comenzará obteniendo la información de las estaciones y las distancias entre ellas de un
archivo de texto, el cual se encuentra en las rutas :

BackAndGreedy/src/datasets/dataset1.txt
BackAndGreedy/src/datasets/dataset1.txt
BackAndGreedy/src/datasets/dataset1.txt

Estos se leen de la siguiente manera:
<nombre_estación_1>;<nombre_estación_2>;<distancia>
Por ejemplo:
E1;E2;100
E2;E3;125
E3;E1;80

Una vez llevada a memoria la información de las estaciones y sus distancias, la aplicación deberá
resolver el problema planteado mediante ambas técnicas. La solución deberá ser mostrada por consola
presentando la siguiente información:
-Técnica utilizada
-Lista de túneles a construir (cada túnel se identifica mediante Estación 1-Estación2)
-Cantidad de metros totales a construir
-Costo de encontrar la solución utilizando alguna métrica que permita medir este costo.
