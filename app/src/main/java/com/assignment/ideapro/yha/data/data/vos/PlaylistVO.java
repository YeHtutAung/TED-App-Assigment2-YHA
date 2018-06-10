package com.assignment.ideapro.yha.data.data.vos;

public class PlaylistVO {
        private int playlistId = 0;
        private String title = null;
        private String imageURL = null;
        private int totalTalks = 0;
        private String description = null;
        private TalksVO talksInPlaylist = null;

        public int getPlaylistId() {
                return playlistId;
        }

        public String getTitle() {
                return title;
        }

        public String getImageURL() {
                return imageURL;
        }

        public int getTotalTalks() {
                return totalTalks;
        }

        public String getDescription() {
                return description;
        }

        public TalksVO getTalksInPlaylist() {
                return talksInPlaylist;
        }
}
