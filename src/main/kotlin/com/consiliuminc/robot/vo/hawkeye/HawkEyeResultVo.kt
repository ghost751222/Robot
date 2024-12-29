package com.consiliuminc.robot.vo.hawkeye

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class HawkEyeResultVo (
    val agentId: String,
    val callId: String,
    val direction: String,
    val duration: Long,
    val caller: String,
    val called: String,
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    val callTime: LocalDateTime,
    val account: String,
    val extension: String,
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    val ringTime: LocalDateTime,
    val hitModels: List<HitModelVo>?,
    val extracted: List<ExtractedVo>?
)