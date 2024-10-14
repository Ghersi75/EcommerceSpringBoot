"use client";

import ItemCard from "@/components/ItemCard";
import Image from "next/image";
import { useState, useEffect } from "react";


export interface Image {
  "id": number,
  "imageLink": string,
  "displayOrder": number
}
export interface Data {
  id: string,
  title: string,
  description: string,
  images: Image[]
}

const compareImageOrder = (image1: Image, image2: Image) => {
  if ( image1.displayOrder < image2.displayOrder ) {
    return -1;
  } else {
    return 1
  }
}

export default function Home() {
  const [data, setData] = useState<Data[]>([])

  useEffect(() => { 
    async function FetchItems() {
      let res = await fetch("http://localhost:8080/items")
      let resultData = await res.json()
      console.log(resultData)
      resultData.sort(compareImageOrder)
      setData(resultData)
    }

    FetchItems()
  }, [])


  return (
    <div className="p-4 w-svw flex items-center justify-start gap-4">
      {data.map((item, id) => {
        return (
          <ItemCard data={item} key={id} />
        )
      })}
    </div>
  );
}
