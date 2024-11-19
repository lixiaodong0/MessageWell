package com.lixd.messagewell.mapper

import com.lixd.messagewell.model.Mood

interface MoodMapper {
    fun findAll(): List<Mood>?
}