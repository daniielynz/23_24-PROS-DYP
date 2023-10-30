#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void)
{
    int fp;
    char buffer[256];

    // Abres la PIPE en modo lectura
    fp = open("FIFO2", O_RDONLY);

    if (fp == -1) {
        printf("Ha ocurrido un error.... \n"); // recuerda borrarlo la segunda vez...
        exit(1);
    }

    while (1) {
        int bytesleidos = read(fp, buffer, sizeof(buffer));
        // Si se leen mas de 0 bits es porque se ha recibido un mensaje
        if (bytesleidos > 0) {
            buffer[bytesleidos] = '\0'; 
            printf("Mensaje recibido: %s", buffer);
        } else if (bytesleidos == 0) {
            printf("Fin de la comunicación.\n"); // si llegan 0 bits, la comunicacion ha terminado
            break;
        } else {
            perror("Error al leer de la tubería FIFO"); // Si la cantidad de bits no es positiva ni 0, da ERROR
            break;
        }
    }
    // Se cierra la tuberia
    close(fp);
    return 0;
}
