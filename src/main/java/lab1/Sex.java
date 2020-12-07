package lab1;

public enum Sex{
    man{
        @Override
        public String toString(){
            return "\tСтать: чоловік";
        }
    },
    woman{
        @Override
        public String toString(){
            return "\tСтать: жінка";
        }
    };

    void show(){
        System.out.println("Метод show() перерахування Sex. Містить поля: "+ man + "  " + woman);
    }

}
