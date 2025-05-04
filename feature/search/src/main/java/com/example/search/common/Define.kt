package com.example.search.common

import com.example.model.ui.ContentInfo
import com.example.model.ui.MediaItem

// 더미 데이터 예시
val testContentList = listOf(
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.cyso.co.kr/data/item/1634988274/64yA7ZGc1.jpg"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "사과",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkntanSrcb8EKzr501R_rVBBf4iU0r-YJfA&s"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "바나나",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://i.namu.wiki/i/rnlYp_Sl7V8KEDv1SYfFf3ZfUuPUjeS0Mjjgrjt9okEHi-9GLNqL9YlWqkEk9CpFDyb1u-yAIKL4wwjIfReC0g.webp"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "이브이",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200327141200390_thumbL"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "부산",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.cyso.co.kr/data/item/1634988274/64yA7ZGc1.jpg"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "사과",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkntanSrcb8EKzr501R_rVBBf4iU0r-YJfA&s"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "바나나",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://i.namu.wiki/i/rnlYp_Sl7V8KEDv1SYfFf3ZfUuPUjeS0Mjjgrjt9okEHi-9GLNqL9YlWqkEk9CpFDyb1u-yAIKL4wwjIfReC0g.webp"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "이브이",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200327141200390_thumbL"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "부산",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.cyso.co.kr/data/item/1634988274/64yA7ZGc1.jpg"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "사과",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkntanSrcb8EKzr501R_rVBBf4iU0r-YJfA&s"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "바나나",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://i.namu.wiki/i/rnlYp_Sl7V8KEDv1SYfFf3ZfUuPUjeS0Mjjgrjt9okEHi-9GLNqL9YlWqkEk9CpFDyb1u-yAIKL4wwjIfReC0g.webp"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "이브이",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200327141200390_thumbL"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "부산",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "0",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "0_0",
                imageUrl = "https://cdn2.smentertainment.com/wp-content/uploads/2024/10/에스파-카리나-Up-무대-이미지.jpg"
            ),
            MediaItem.Video(
                id = "0_1",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "0_2",
                imageUrl = "https://images.openai.com/thumbnails/12a2b47b847ffbd5fc39dbca23e49043.jpeg"
            )
        ),
        profileUrl = "https://i.namu.wiki/i/2yoJvN6w-fUtbpz4fWqY_wn7B1tuLADIGM5YVTOJY5qaO0JwqlWzpuv-X3GRzUGcnzvnp9KOS6wn5x_4EJo0yQ.webp",
        title = "카리나의 새로운 솔로곡 'Up' 무대 비하인드",
        profileName = "Karina Official",
        viewCount = "1.5M",
        timeAgo = "2시간 전"
    ),
    ContentInfo(
        id = "1",
        mediaItemList = listOf(
            MediaItem.Video(
                id = "1_0",
                videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                thumbnailsUrl = "https://www.news1.kr/_next/image?url=https%3A%2F%2Fi3n.news1.kr%2Fsystem%2Fphotos%2F2023%2F12%2F4%2F6361299%2Fhigh.jpg&w=1920&q=75"
            ),
            MediaItem.Image(
                id = "1_1",
                imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2024/11/15/ef84b3b9-12a4-49af-9bbc-3ac064db216b.jpg"
            ),
            MediaItem.Image(
                id = "1_2",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7N6uPq6jrh6AToZM-qN7oiEq2xGS4LZs3YHb3FJOjRlTbaLdGJoYFAhscrcUkFNObc8VzRY"
            )
        ),
        profileUrl = "https://iuedelweiss.tistory.com/258",
        title = "아이유의 생일 기념 고화질 화보 모음",
        profileName = "IU Official",
        viewCount = "2.3M",
        timeAgo = "5시간 전"
    ),
    ContentInfo(
        id = "2",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "2_0",
                imageUrl = "https://cdn.seoulwire.com/news/photo/202407/615343_816176_94.jpg"
            ),
            MediaItem.Image(
                id = "2_1",
                imageUrl = "https://cdn.baccro.com/news/photo/201808/16499_40463_042.jpg"
            ),
            MediaItem.Image(
                id = "2_2",
                imageUrl = "https://dimg.donga.com/wps/NEWS/IMAGE/2024/11/27/130512780.1.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "아이린의 봄 분위기 물씬 나는 스타일링",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://flexible.img.hani.co.kr/flexible/normal/960/960/imgdb/resize/2019/0121/00501111_20190121.webp"
            ),
            MediaItem.Image(
                id = "3_1",
                "https://image.yes24.com/images/chyes24/froala/0/55354/91853.jpg"
            ),
            MediaItem.Image(
                id = "3_2",
                "https://images.mypetlife.co.kr/content/uploads/2021/10/19151330/corgi-g1a1774f95_1280-1024x682.jpg"
            )
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "강아지",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.cyso.co.kr/data/item/1634988274/64yA7ZGc1.jpg"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "사과",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkntanSrcb8EKzr501R_rVBBf4iU0r-YJfA&s"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "바나나",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://i.namu.wiki/i/rnlYp_Sl7V8KEDv1SYfFf3ZfUuPUjeS0Mjjgrjt9okEHi-9GLNqL9YlWqkEk9CpFDyb1u-yAIKL4wwjIfReC0g.webp"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "이브이",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),
    ContentInfo(
        id = "3",
        mediaItemList = listOf(
            MediaItem.Image(
                id = "3_0",
                "https://www.visitbusan.net/uploadImgs/files/hqimgfiles/20200327141200390_thumbL"
            ),
        ),
        profileUrl = "https://www.mk.co.kr/news/photos/11271822",
        title = "부산",
        profileName = "Irene Channel",
        viewCount = "1.1M",
        timeAgo = "1일 전"
    ),

)