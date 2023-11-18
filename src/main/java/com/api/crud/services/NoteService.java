package com.api.crud.services;

import com.api.crud.models.NoteModel;
import com.api.crud.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    // CREATE
    public NoteModel saveNote(NoteModel note) {
        return noteRepository.save(note);
    }

    // READ
    public ArrayList<NoteModel> getNotes() {
        return (ArrayList<NoteModel>) noteRepository.findAll();
    }

    // UPDATE 1/2
    public Optional<NoteModel> getById(Long id) {
        return this.noteRepository.findById(id);
    }

    // UPDATE 2/2
    public NoteModel updateById(NoteModel request, Long id) {
        NoteModel note = noteRepository.findById(id).get();

        note.setText(request.getText());

        noteRepository.save(note);

        return note;
    }

    // DELETE
    public Boolean deleteNote(Long id) {
        try {
            noteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return false;
        }
    }
}
