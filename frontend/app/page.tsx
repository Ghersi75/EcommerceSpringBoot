"use client";

import ItemCard from "@/components/ItemCard";
import { ItemData } from "@/lib/types/StoreItemTypes";
import { compareDisplayOrder } from "@/lib/utils";
import { useState, useEffect } from "react";

export default function Home() {
  const [data, setData] = useState<ItemData[]>([])

  useEffect(() => { 
    async function FetchItems() {
      let res = await fetch("http://localhost:8080/items")
      let resultData = await res.json()
      resultData.sort(compareDisplayOrder)
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
