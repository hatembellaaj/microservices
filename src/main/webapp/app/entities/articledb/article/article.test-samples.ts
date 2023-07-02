import { IArticle, NewArticle } from './article.model';

export const sampleWithRequiredData: IArticle = {
  id: '98a873ee-1442-4553-9412-ea586fba6b1e',
  name: 'channels Sports Poland',
};

export const sampleWithPartialData: IArticle = {
  id: 'da2425bf-bc49-40c9-967b-618f61b7505b',
  name: 'composite Visionary',
  price: 25903,
  idcategory: 'Computer granular Devolved',
};

export const sampleWithFullData: IArticle = {
  id: 'f0bde51c-8885-43c4-9caf-49d521a0c62d',
  name: 'plum Lakes',
  price: 59118,
  idcategory: 'Loan Soft',
};

export const sampleWithNewData: NewArticle = {
  name: 'Mouse',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
