interface Image {
  "id": number,
  "imageLink": string,
  "displayOrder": number
}

export interface ItemData {
  id: string,
  title: string,
  description: string,
  images: Image[]
}