package Medium.two_pointers;

public class Push_Dominoes {
    public static void main(String[] args) {

        System.out.print(pushDominoes("."));
    }

    public static String pushDominoes(String dominoes) {

        char[] arr = dominoes.toCharArray();
        StringBuilder sb = new StringBuilder();

        int idx = -1;

        int rLoc = -1;


        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == 'R'){
                if(rLoc != -1){
                    while(rLoc<i-1){
                        rLoc++;
                        arr[rLoc] = 'R';
                    }
                }
                rLoc = i;
            }

            if(arr[i] == 'L'){
                if(rLoc == -1){
                    int temp = i-1;
                    while(temp>=0 && arr[temp] == '.'){
                        arr[temp] = 'L';
                        temp--;
                    }
                }else{
                    int temp = (i-rLoc-1)/2;
                    for(int j=1; j<=temp; j++){
                        arr[rLoc+j] = 'R';
                        arr[i-j] = 'L';
                    }
                    rLoc = -1;
                }
            }
        }

        if(rLoc != -1){
            for(int i = rLoc+1; i<arr.length; i++){
                arr[i] = 'R';
            }
        }

        return new String(arr);
    }
}
