package com.example.shakespearinsults.service;

import com.example.shakespearinsults.model.Insult;
import com.example.shakespearinsults.repository.InsultRepository;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InsultServiceTest {

    @Test
    void getAll() {
        //Given
        InsultRepository insultRepository = mock(InsultRepository.class);
        InsultService insultService = new InsultService(insultRepository);
        List<Insult> expectedList = Arrays.asList(new Insult("Testing"), new Insult("List"), new Insult("Of"), new Insult("Strings"));
        when(insultRepository.getAll()).thenReturn(expectedList);


        //When
        List<Insult> retrievedList = insultService.getAll();

        //Then
        assertEquals(expectedList, retrievedList);
        verify(insultRepository).getAll();

    }
}