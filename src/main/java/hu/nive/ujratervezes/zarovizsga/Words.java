package hu.nive.ujratervezes.zarovizsga;

public class Words {

    public Words() {
    }

    public boolean hasMoreDigits(String word){
        int number=0;
        int character=0;
        boolean result;

            for(int i=0; i<=word.length()-1; i++){
               int s= word.charAt(i);
                if (word.charAt(i)>=49 && word.charAt(i)<=57){
                    number++;
                }
                else{
                    character++;
                }
            }
            if(number>character){
                return true;
            }

        return false;
    }
}
