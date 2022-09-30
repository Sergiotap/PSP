#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
int main()
{   
    pid_t pid;
	pid = fork ();
    int contador, n, primo;
    printf( "\n   " );
    if (pid == -1) // Ha ocurrido un error
	{
		printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
	}
    if (pid==0){
        for ( n = 100000 ; n <= 150000 ; n++ )
        {
            primo = 1;
            contador = 2;

            while ( contador <= n / 2 && primo )
            {
                if ( n % contador == 0 )
                    primo = 0;

                contador++;
            }

            if ( primo )
                printf( "%d ", n );
        }
    }
    else{
        for ( n = 150000 ; n <= 200000 ; n++ )
        {
            primo = 1;
            contador = 2;

            while ( contador <= n / 2 && primo )
            {
                if ( n % contador == 0 )
                    primo = 0;

                contador++;
            }

            if ( primo )
                printf( "%d ", n );
        }
    }
    return 0;
}
