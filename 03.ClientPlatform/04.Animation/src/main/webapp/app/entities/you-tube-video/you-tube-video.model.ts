export interface IYouTubeVideo {
  id: number;
  workspace?: string | null;
  creator?: string | null;
  theme?: string | null;
  content?: string | null;
  backgroundMusic?: string | null;
  videoTime?: string | null;
  gender?: string | null;
  videolanguage?: string | null;
  subtitles?: string | null;
}

export type NewYouTubeVideo = Omit<IYouTubeVideo, 'id'> & { id: null };
