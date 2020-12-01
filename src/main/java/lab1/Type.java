package lab1;

public enum Type{
    all{
        @Override
        public String toString(){
            return "Даний користувач має загальний тип доступ";
        }
    },
    teacher(3){
        @Override
        public String toString(){
            return "Необідний тип доступу користувача - викладач";
        }
    },
    worker(4){
        @Override
        public String toString(){
            return "Необхідний тип доступу користувача - робітник";

        }
    },
    another;


    int prior;

    Type(){

    }

    Type(int p){
        this.prior = p;
    }


    @Override
    public String toString(){
        return "enum Тип доступу";

    }
    void show(){
        for (Type type: Type.values()){
            System.out.println(type);
        }
        System.out.println("");
    }
}

