package com.hulk.songzinese

class Word {
    private var wordInSongzi: String = ""
    private var wordInMandrain: String = ""
    private var imageResourceId: Int = -1

    constructor(wordInMandrain: String, wordInSongzi: String) {
        this.wordInSongzi = wordInSongzi
        this.wordInMandrain = wordInMandrain
    }

    constructor(wordInMandrain: String, wordInSongzi: String, imageResourceId: Int) {
        this.wordInSongzi = wordInSongzi
        this.wordInMandrain = wordInMandrain
        this.imageResourceId = imageResourceId
    }

    fun getWordInSongzi(): String {
        return this.wordInSongzi
    }
    fun getWordInMandrain(): String {
        return this.wordInMandrain
    }

    fun getImageResourceId(): Int{
        return this.imageResourceId
    }
}