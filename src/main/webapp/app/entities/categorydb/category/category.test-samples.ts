import { ICategory, NewCategory } from './category.model';

export const sampleWithRequiredData: ICategory = {
  id: '0aaf2144-edc0-4adb-933d-efd5dc5e205d',
  name: 'Borders bus',
};

export const sampleWithPartialData: ICategory = {
  id: 'fc12121b-61d9-499b-9e68-0cf6dd7bb57e',
  name: 'solutions benchmark',
  description: 'Concrete',
};

export const sampleWithFullData: ICategory = {
  id: 'cf16d432-ddbf-4e9b-b54b-41572efeb01a',
  name: 'Borders User-centric Handmade',
  description: 'up out-of-the-box',
};

export const sampleWithNewData: NewCategory = {
  name: 'matrix',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
