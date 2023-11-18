package com.api.crud.controllers;

import com.api.crud.models.NoteModel;
import com.api.crud.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public NoteModel saveNote(@RequestBody NoteModel note) {
        return this.noteService.saveNote(note);
    }

    @GetMapping
    public ArrayList<NoteModel> getNotes() {
        return this.noteService.getNotes();
    }

    @GetMapping(path = "/{id}")
    public Optional<NoteModel> getNoteById(@PathVariable("id") Long id) {
        return this.noteService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public NoteModel updateNoteById(@RequestBody NoteModel request, Long id) {
        return  this.noteService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        boolean result = this.noteService.deleteNote(id);

        if (result) {
            return "La nota ha sido eliminada";
        } else {
            return "La nota con ID:" + id + " no existe";
        }
    }
}
