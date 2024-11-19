package com.lixd.messagewell.service.impl

import com.lixd.messagewell.mapper.MoodMapper
import com.lixd.messagewell.model.Mood
import com.lixd.messagewell.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MoodServiceImpl : MoodService {

    @Autowired
    lateinit var moodMapper: MoodMapper

    override fun getMood(): List<Mood> {
        return moodMapper.findAll() ?: emptyList()
    }
}