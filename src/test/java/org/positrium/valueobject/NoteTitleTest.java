package org.positrium.valueobject;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

public class NoteTitleTest {

    @Test
    public void valid_value() {
        try{
            NoteTitle noteTitle = new NoteTitle("abcde");
            assertThat(noteTitle).isNotNull();
        }catch(InvalidateFieldException ex){
            fail(ex.getMessage());
        }
    }

    @Test
    public void invalid_value(){
        try{
            NoteTitle noteTitle = new NoteTitle("abcde0");
            fail();
        }catch(InvalidateFieldException ex){
            assertThat(ex).isNotNull();
        }
    }

    @Test
    public void invalid2_value(){
        try{
            NoteTitle noteTitle = new NoteTitle("");
            fail();
        }catch(InvalidateFieldException ex){
            assertThat(ex).isNotNull();
        }
    }

    @Test
    public void invalid3_value(){
        try{
            NoteTitle noteTitle = new NoteTitle(null);
            fail();
        }catch(InvalidateFieldException ex){
            assertThat(ex).isNotNull();
        }
    }
}
