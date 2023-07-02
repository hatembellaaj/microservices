export interface IArticle {
  id: string;
  name?: string | null;
  price?: number | null;
  idcategory?: string | null;
}

export type NewArticle = Omit<IArticle, 'id'> & { id: null };
