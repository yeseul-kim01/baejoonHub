import java.util.*;
import java.util.stream.*;

class Solution {

    static class Song {
        int index;
        String genre;
        int play;

        Song(int index, String genre, int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 1) 분리된 배열을 하나의 테이블(Song 리스트)로 변환
        List<Song> songs = IntStream.range(0, genres.length)
                .mapToObj(i -> new Song(i, genres[i], plays[i]))
                .collect(Collectors.toList());

        // 2) 장르별 총 재생수 계산
        Map<String, Integer> genreTotal = songs.stream()
                .collect(Collectors.groupingBy(
                        song -> song.genre,
                        Collectors.summingInt(song -> song.play)
                ));

        // 3) 장르별 곡 리스트 그룹핑
        Map<String, List<Song>> genreSongs = songs.stream()
                .collect(Collectors.groupingBy(song -> song.genre));

        // 4) 장르를 총 재생수 기준으로 정렬
        return genreTotal.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .flatMap(entry -> genreSongs.get(entry.getKey()).stream()
                        .sorted((a, b) -> {
                            if (b.play == a.play) {
                                return a.index - b.index;
                            }
                            return b.play - a.play;
                        })
                        .limit(2)
                )
                .mapToInt(song -> song.index)
                .toArray();
    }
}