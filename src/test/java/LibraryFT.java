import lab1.*;
import org.junit.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class LibraryFT {

    @Test
    public void searchReaderByIdCompareIdTicket(){
        Library library = new Library();

        Reader reader = Mockito.mock(Reader.class);
        library.setReaders(reader);

        when(reader.getIdTicket()).thenReturn(10);

        int act = library.searchReaderById(10).getIdTicket();
        verify(library.searchReaderById(10), atLeast(1)).getIdTicket();

        assertEquals(act, 10);
    }


    @Test
    public void searchReaderByIdSpyCompareIdTicket(){
        Library library = new Library();

        Reader reader = Mockito.spy(new Reader());
        library.setReaders(reader);

        when(reader.getIdTicket()).thenReturn(10);

        int act = library.searchReaderById(10).getIdTicket();
        verify(library.searchReaderById(10), atLeast(1)).getIdTicket();

        assertEquals(act, 10);
    }


    @Test
    public void deleteRecordRemoveFrom() {
        Library library = Mockito.mock(Library.class);

        Reader r =Mockito.mock(Reader.class);
        Book b =Mockito.mock(Book.class);
        Librarian l = Mockito.mock(Librarian.class);

        library.setRecord(r, b, l);
        library.deleteRecord(r, 0);

    }




}