package com.hulk.songzinese

class Word {
    private var wordInSongzi: String = ""
    private var wordInMandrain: String = ""
    private var image_resource_id: Int = -1

    constructor(wordInSongzi: String, wordInMandrain: String) {
        this.wordInSongzi = wordInSongzi
        this.wordInMandrain = wordInMandrain
    }
    constructor(wordInSongzi: String, wordInMandrain: String, image_resource_id: Int) {
        this.wordInSongzi = wordInSongzi
        this.wordInMandrain = wordInMandrain
        this.image_resource_id = image_resource_id
    }


}