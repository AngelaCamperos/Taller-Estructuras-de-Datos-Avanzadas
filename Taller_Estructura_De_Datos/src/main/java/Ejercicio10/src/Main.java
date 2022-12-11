import java.util.Scanner;

public class Main {

    public static void main( String[] args ){

        Main m = new Main();
        m.begin();

    }

    void begin(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = Integer.parseInt( in.next() );
            int[] a = new int[N];
            for(int i=0; i<N; ++i){
                a[i] = Integer.parseInt( in.next() );
            }
            int money = Integer.parseInt(in.next());
            int book1=-1 , book2=-1;
            for(int i=0; i<N-1; ++i){

                for(int j=i+1; j<N; ++j){

                    if( a[i]+a[j] == money ){
                        if( book1 == -1 && book2 == -1 ){
                            book1=i;
                            book2=j;
                        }
                        else if( Math.abs(a[i]-a[j])<Math.abs(a[book1]-a[book2]) ){
                            book1=i;
                            book2=j;
                        }
                    }
                }
            }
            int i=a[book1] , j=a[book2] ;
            System.out.printf("Peter should buy books whose prices are %d and %d.\n\n", Math.min(i,j) , Math.max(i,j)  );
        }
    }

}
