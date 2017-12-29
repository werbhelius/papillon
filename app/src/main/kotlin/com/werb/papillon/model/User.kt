package com.werb.papillon.model

/**
 * Created by wanbo on 2017/12/28.
 */
class User {
    val id: String? = null
    val name: String? = null
    val username: String? = null
    val html_url: String? = null
    val avatar_url: String? = null
    val bio: String? = null
    val location: String? = null
    val links: Links? = null
    val buckets_count: Int = 0
    val comments_received_count: Int = 0
    val followers_count: Int = 0
    val followings_count: Int = 0
    val likes_count: Int = 0
    val likes_received_count: Int = 0
    val projects_count: Int = 0
    val rebounds_received_count: Int = 0
    val shots_count: Int = 0
    val teams_count: Int = 0
    val can_upload_shot: Boolean = false
    val type: String? = null
    val pro: Boolean = false
    val buckets_url: String? = null
    val followers_url: String? = null
    val following_url: String? = null
    val likes_url: String? = null
    val shots_url: String? = null
    val teams_url: String? = null
    // UTC 时间格式
    val created_at: String? = null
    val updated_at: String? = null
}

class Links {
    val web: String? = null
    val twitter: String? = null
}