import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'category',
        data: { pageTitle: 'Categories' },
        loadChildren: () => import('./categorydb/category/category.module').then(m => m.CategorydbCategoryModule),
      },
      {
        path: 'article',
        data: { pageTitle: 'Articles' },
        loadChildren: () => import('./articledb/article/article.module').then(m => m.ArticledbArticleModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
