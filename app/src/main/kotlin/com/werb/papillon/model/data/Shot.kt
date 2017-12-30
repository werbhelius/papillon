package com.werb.papillon.model.data

/**
 * Created by wanbo on 2017/12/29.
 */
class Shot {

    val id: String? = null
    val title: String? = null
    val description: String? = null
    val width: Int = 0
    val height: Int = 0
    val views_count: Int = 0
    val likes_count: Int = 0
    val comments_count: Int = 0
    val attachments_count: Int = 0
    val rebounds_count: Int = 0
    val buckets_count: Int = 0
    val created_at: String? = null
    val updated_at: String? = null
    val html_url: String? = null
    val attachments_url: String? = null
    val buckets_url: String? = null
    val comments_url: String? = null
    val likes_url: String? = null
    val projects_url: String? = null
    val rebounds_url: String? = null
    val animated = false
    val tags: Array<String>? = null
    val user: User? = null

}

class image {

    val hidpi: String? = null
    val normal: String? = null
    val teaser: String? = null

}

class team {

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
    val members_count: Int = 0
    val projects_count: Int = 0
    val rebounds_received_count: Int = 0
    val shots_count: Int = 0
    val can_upload_shot = false
    val type: String? = null
    val pro = false
    val buckets_url: String? = null
    val followers_url: String? = null
    val following_url: String? = null
    val likes_url: String? = null
    val members_url: String? = null
    val shots_url: String? = null
    val team_shots_url: String? = null
    val created_at: String? = null
    val updated_at: String? = null

}
