import dayjs from 'dayjs/esm';
import { IUser } from 'app/entities/user/user.model';
import { ITag } from 'app/entities/tag/tag.model';
import { IBlog } from 'app/entities/blog/blog.model';

export interface IPost {
  id: number;
  title?: string | null;
  content?: string | null;
  date?: dayjs.Dayjs | null;
  user?: Pick<IUser, 'id'> | null;
  tags?: ITag[] | null;
  blog?: IBlog | null;
}

export type NewPost = Omit<IPost, 'id'> & { id: null };
