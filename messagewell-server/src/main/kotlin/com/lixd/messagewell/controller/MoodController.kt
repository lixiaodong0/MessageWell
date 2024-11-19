package com.lixd.messagewell.controller

import com.lixd.messagewell.model.BaseResult
import com.lixd.messagewell.model.Mood
import com.lixd.messagewell.service.MoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 心情Controller
 */
@RequestMapping("/mood")
@RestController
class MoodController {

    @Autowired
    private lateinit var moodService: MoodService

    @GetMapping("/get")
    fun getMoodTags(): BaseResult<List<Mood>> {
        return BaseResult.success(moodService.getMood())
    }
}