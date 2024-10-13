"use client";

import ItemCard from "@/components/ItemCard";
import Image from "next/image";
import { useState, useEffect } from "react";

interface Data {
  id: String,
  title: String,
  description: String,
  imageLink: String
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
    <div className="p-4 w-svw h-svh flex items-center justify-center">
      {data.map((item) => {
        return (
          <div> {item.id} </div>
        )
      })}
    </div>
  );
}
