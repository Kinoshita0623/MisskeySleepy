package org.panta.misskeysleepy.viewmodel

import android.databinding.ObservableField
import android.view.View
import org.panta.misskeysleepy.entities.Note
import java.lang.IllegalArgumentException

class NoteViewModel {
    val noteStatus = ObservableField<String>()
    /*val isVisibleNoteStatus: ObservableField<Boolean> = ObservableField()
        get() {
            val status=  noteStatus.get() != null && noteStatus.get()?.isNotBlank() == true
            field.set(status)
            return field
        }*/

    //userに関連すること
    val userName = ObservableField<String>()
    val userId = ObservableField<String>()
    val avatarUrl = ObservableField<String>()

    val elapsedTime = ObservableField<String>()
    //投稿に関連すること
    val text = ObservableField<String>()

    val subNoteVisibility = ObservableField<Int>()
    val subNoteUserName = ObservableField<String>()
    val subNoteUserId = ObservableField<String>()
    val subNoteAvatarUrl = ObservableField<String>()
    val subNoteText = ObservableField<String>()


    fun setContent(note: Note){

        if(note.reply != null){
            //reply
            setNote(note)
            noteStatus.set("${note.user?.name}が返信しました")
        }else if(note.reNoteId == null && (note.text != null || note.files != null)){
            //Note
            setNote(note)
        }else if(note.reNoteId != null && note.text == null && note.files.isNullOrEmpty()){
            //reNote
            setNote(note.reNote)
            noteStatus.set("${note.user?.name}がリノートしました")

        }else if(note.reNoteId != null && (note.text != null || note.files != null)){
            //quote
            setNote(note)
            noteStatus.set("${note.user?.name}が引用リノートしました")
        }else{
            throw IllegalArgumentException("よくわからないタイプのノート: $note")
        }
        userName.set(note.user?.name?: note.user?.userName)
        userId.set(note.user?.userName)
        text.set(note.text)

        avatarUrl.set(note.user?.avatarUrl)
    }
    
    //quote & note & reply
    private fun setNote(note: Note?){
        userId.set(note?.user?.userName)
        userName.set(note?.user?.name)
        avatarUrl.set(note?.user?.avatarUrl)
        //elapsedTime.set(Elapa)
        text.set(note?.text)

        if(note?.reNote != null){
            val reNote = note.reNote
            subNoteAvatarUrl.set(reNote.user?.avatarUrl)
            subNoteUserId.set(reNote.user?.userName)
            subNoteUserName.set(reNote.user?.name)

            subNoteText.set(reNote.text)
        }else{
            subNoteVisibility.set(View.GONE)
        }
    }




}