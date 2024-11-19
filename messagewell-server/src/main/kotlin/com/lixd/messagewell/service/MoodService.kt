package com.lixd.messagewell.service

import com.lixd.messagewell.model.Mood

interface MoodService {
    fun getMood(): List<Mood>
}