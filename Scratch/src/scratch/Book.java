package scratch;

//public class Book {
//    
//}
interface Updater<T> {
    public T update(T t);
}

abstract class AbstractUpdater<T extends AbstractUpdater<T>> implements Updater<T>{}

class Book extends AbstractUpdater<Book> {

    @Override
    public Book update(Book t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

class User extends AbstractUpdater<Book> {

    @Override
    public Book update(Book t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
class Foo {
    static <T> void doSomething(Updater<T> u){
        
    }
}