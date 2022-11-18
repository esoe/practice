package ru.molokoin.j110.lab03.task1.SimplyList1;

/**
 * Класс - реализация звена односвязного списка
 * Односвязный список - 
 * это структура, хранящая данные в виде цепочки, каждый узел которой хранит очередное значение списка и ссылку на следующий узел. 
 * Ссылка на следующий узел последнего элемента списка равна null.
 * 
 * TODO обработать исключения:
 * - 
 * 
 */
public class Pearl {
    private Object gem;
    private Pearl next;

    //использую для переписи данных массива
    public Pearl(){
        this(null, null);
    }
    public Pearl(Object gem){
        this(gem, null);
    }
    public Pearl(Object gem, Pearl next){
        setGem(gem);
        setNext(next);
    }
    /**
     * Удаляет с ожерелья последнюю жемчужину, 
     * возвращает эту жемчужину
     * @return
     * TODO в списке может быть только один элемент
     */
    public Pearl executeLast(){
        //получил последнюю жемчужину, можно удалять ее с ожерелья
        Pearl last = getLast();//можно данные получать в том же переборе, где и удаление происходит (исключим один перебор)

        /**
         * удаление последней жемчужины.
         * в предпоследней жемчужине next приравниваем null
         */
        int i = 0;
        Pearl current = this;
        while (i < lenght()-1){
            current = current.next;
            i++;
        }
        current.setNext(null);
        return last;
    }
    public int lenght(){
        int lenght = 0;
        Pearl current = this;
        while(current.next != null){
            current = current.getNext();
            lenght++;
        }
        return lenght;
    }
    /**
     * Рекурсивно печатает данные, пока не упрется в next = null
     */
    public void print(){
        System.out.println(gem);
        if (next != null){
            getNext().print();
        }
    }
    /**
     * Добавление элемента в конец списка
     * перебирает жемчужины до  конца, последней присваивет в next новую жемчужину
     * @param gem
     */
    public void addLast(Object gem){
        if(this.gem == null){setGem(gem);}
        else {
            Pearl pearl = new Pearl(gem);
            Pearl current = this;
            while (current.next != null){
                current = current.next;
            }
            current.next = pearl;
        }
    }
    /**
     * Добавление элемента в начало списка.
     * 
     * @param gem
     */
    public void addFirst(Object gem){
        if(this.gem == null){setGem(gem);}
        else {
            //создаем новую жемчужину с параметрами первой
            Pearl pearl = new Pearl(getGem());
            pearl.setNext(getNext());
            //пишем в текущую-первую жемчужину новые данные
            setGem(gem);
            //и устанавливаем ссылку на новую жемчужину
            setNext(pearl);
        }
    }
    /**
     * возвращает последнюю жемчужину-Pearl
     * getLast().getGem()//вернет данные последней жемчужины
     * @return
     */
    public Pearl getLast(){
        Pearl current = this;
        while (current.next != null){
            current = current.next;
        }
        return current;
    }
    /**
     * @param gem the gem to set
     */
    public void setGem(Object gem) {
        this.gem = gem;
    }
    /**
     * Возвращает данные-gem жемчужины
     * @return the gem
     */
    public Object getGem() {
        return gem;
    }
    /**
     * @param next the next to set
     */
    public void setNext(Pearl next) {
        this.next = next;
    }
    /**
     * @return the next
     */
    public Pearl getNext() {
        return next;
    }
}
