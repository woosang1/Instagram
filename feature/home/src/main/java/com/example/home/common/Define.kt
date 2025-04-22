package com.example.home.common

import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem

// 더미 데이터 예시
val testContentList = listOf(
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"),
            MediaItem.Image("https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"),
            MediaItem.Image("https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"),
            MediaItem.Image("https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"),
            MediaItem.Image("https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),

    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"),
            MediaItem.Image("https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"),
            MediaItem.Image("https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),

    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"),
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), // 영상 샘플
            MediaItem.Image("https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg")
        ),
        channelThumbnailUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        channelName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Video("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"),
            MediaItem.Image("https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"),
            MediaItem.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY")
        ),
        channelThumbnailUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        channelName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"),
            MediaItem.Image("https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"),
            MediaItem.Image("https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        thumbnails = listOf(
            MediaItem.Image("https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"),
            MediaItem.Image("https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"),
            MediaItem.Image("https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg")
        ),
        channelThumbnailUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        channelName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
)