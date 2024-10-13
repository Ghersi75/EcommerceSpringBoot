"use client";

import ItemCard from "@/components/ItemCard";
import Image from "next/image";
import { useState, useEffect } from "react";

export interface Data {
  id: string,
  title: string,
  description: string,
  imageLink: string
}

export default function Home() {
  const [data, setData] = useState<Data[]>([])

  useEffect(() => { 
    async function FetchItems() {
      let res = await fetch("http://localhost:8080/items")
      let data = await res.json()
      console.log(data)
      setData(data)
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
