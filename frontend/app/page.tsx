"use client";

import ItemCard from "@/components/ItemCard";
import useFetchItems from "@/lib/hooks/useFetchItems";

export default function Home() {
  const { data, isLoading, error } = useFetchItems();

  if (error) {
    // TODO add actual error handling logic
    console.log(error)
  }
  
  return (
    <>
    {/* TODO Create a scheleton component for loading */}
      {isLoading  ? <div> loading </div> :
        <div className="p-4 w-svw flex flex-1 items-start justify-center gap-4">
          {data.map((item, id) => {
            return (
              <ItemCard data={item} key={id} />
            )
          })}
        </div>
      }
    </>
  );
}
