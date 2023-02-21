#include <stdio.h>
#include <unistd.h>

int main()
{
    pid_t pid, pid1;
    fflush(stdout);
    pid = fork();
    fflush(stdout); 
    pid1 = fork();
    if(pid==0)
    {
         printf("%d is the first child\n", getpid() );
    }
    else if(pid>0)
    {
         printf("%d is the first parent\n", pid);
        wait();
    }
    if(pid1==0)
    {
         printf("%d is the second child\n", getpid() );
    }
    else if(pid1>0)
    {
         printf("%d is the second child\n", pid1);
        wait();
    }

    return 0;
}
