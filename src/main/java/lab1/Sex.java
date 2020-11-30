package lab1;

public enum Sex{
    man{
        @Override
        public String toString(){
            return "Стать: чоловік";
        }
    },
    woman{
        @Override
        public String toString(){
            return "Стать: жінка";
        }
    };

    void show(){
        System.out.println("Метод show() перерахування Sex. Містить поля: "+ man + "  " + woman);
    }

}
