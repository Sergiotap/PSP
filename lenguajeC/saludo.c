#include <stdio.h>
#define LONGITUD_MAX_NOMBRE 20

int main(void){
    char nombre[LONGITUD_MAX_NOMBRE];
	printf("Introduce tu nombre: ");
    scanf("%s",nombre);
	printf("Bienvenido %s\n" ,nombre);
	return 0;
}
